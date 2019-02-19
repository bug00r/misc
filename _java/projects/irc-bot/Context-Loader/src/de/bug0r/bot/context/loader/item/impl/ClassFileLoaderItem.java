package de.bug0r.bot.context.loader.item.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.loader.exception.ContextLoadException;
import de.bug0r.bot.context.loader.item.LoaderItem;

public class ClassFileLoaderItem implements LoaderItem {

	private Map<String,Context> loadedContext;
	
	public ClassFileLoaderItem(Map<String,Context> loadedContext) {
		if ( loadedContext == null ) throw new IllegalArgumentException("no contexts given");
		this.loadedContext = loadedContext;
	}
	
	@Override
	public Context load(String source) throws ContextLoadException {
		ContextClassLoader classLoader = new ContextClassLoader();
		Context context = null;
		context = this.loadContext(source, classLoader);
		return context;
	}

	@Override
	public Context load(String source, String parent)
			throws ContextLoadException {
		Context parentContext = this.loadedContext.get(parent);
		if ( parentContext == null ) throw new ContextLoadException("no parent given: " + parent);
		ClassLoader parentClassLoader = new ContextClassLoader(parentContext.getClass().getClassLoader());
		ContextClassLoader classLoader = new ContextClassLoader(parentClassLoader);
		Context context = this.loadContext(source, classLoader);
		return context;
	}
	
	public static class ContextClassLoader extends ClassLoader {
		public ContextClassLoader() {
		}
		public ContextClassLoader(ClassLoader parent) {
			super(parent);
		}
        public Class<?> findClass(String className, byte[] bytes) {
            return defineClass(className, bytes, 0, bytes.length);
        }
    }

	private Context loadContext(String source, ContextClassLoader classLoader) {
		try {
			URI uri = new URI(source);
			File classFile = new File(uri);
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(classFile));
			byte [] data = new byte[in.available()];
			in.read(data);
			Class<?> contextClass = classLoader.findClass(uri.getHost(), data);
			return (Context) contextClass.newInstance();
		} catch (ClassCastException e) {
			throw new ContextLoadException(e);
		} catch (MalformedURLException e) {
			throw new ContextLoadException(e);
		} catch (URISyntaxException e) {
			throw new ContextLoadException(e);
		} catch (FileNotFoundException e) {
			throw new ContextLoadException(e);
		} catch (IOException e) {
			throw new ContextLoadException(e);
		} catch (InstantiationException e) {
			throw new ContextLoadException(e);
		} catch (IllegalAccessException e) {
			throw new ContextLoadException(e);
		}
	}
	
}
