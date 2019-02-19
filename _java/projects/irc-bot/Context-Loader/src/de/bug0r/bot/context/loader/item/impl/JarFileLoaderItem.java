package de.bug0r.bot.context.loader.item.impl;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.loader.exception.ContextLoadException;
import de.bug0r.bot.context.loader.item.LoaderItem;

public class JarFileLoaderItem implements LoaderItem {

	private Map<String,Context> loadedContext;
	
	public JarFileLoaderItem(Map<String,Context> loadedContext) {
		if ( loadedContext == null ) throw new IllegalArgumentException("no contexts given");
		this.loadedContext = loadedContext;
	}
	
	@Override
	public Context load(String source) throws ContextLoadException {
		Context context = null;
		context = this.loadContext(source, null);
		return context;
	}
	
	@Override
	public Context load(String source, String parent)
			throws ContextLoadException {
		Context parentContext = this.loadedContext.get(parent);
		if ( parentContext == null ) throw new ContextLoadException("no parent given: " + parent);
		Context context = this.loadContext(source, parentContext.getClass().getClassLoader());
		return context;
	}
	
	private Context loadContext(String source, ClassLoader parentClassLoader) {
		try {
			JarURLConnection jarCon = (JarURLConnection)new URL(source).openConnection();
			Attributes attributes = jarCon.getMainAttributes();
			URLClassLoader classLoader;
			if ( parentClassLoader != null ) {
				classLoader = URLClassLoader.newInstance(new URL[]{ jarCon.getURL()},parentClassLoader);
			} else {
				classLoader = URLClassLoader.newInstance(new URL[]{ jarCon.getURL()},ClassLoader.getSystemClassLoader());
			}
			Class<?> contextClass = classLoader.loadClass(attributes.getValue(Name.MAIN_CLASS));
			return (Context) contextClass.newInstance();
		} catch (ClassCastException e) {
			throw new ContextLoadException(e);
		}  catch (MalformedURLException e) {
			throw new ContextLoadException(e);
		} catch (IOException e) {
			throw new ContextLoadException(e);
		} catch (ClassNotFoundException e) {
			throw new ContextLoadException(e);
		} catch (InstantiationException e) {
			throw new ContextLoadException(e);
		} catch (IllegalAccessException e) {
			throw new ContextLoadException(e);
		}
	}

}
