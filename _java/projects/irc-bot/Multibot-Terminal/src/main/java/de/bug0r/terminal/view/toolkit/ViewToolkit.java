package de.bug0r.terminal.view.toolkit;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.terminal.view.toolkit.item.ComponentBuilder;
import de.bug0r.terminal.view.toolkit.item.NullBuilder;
import de.bug0r.terminal.view.toolkit.item.impl.ConnectionDialogBuilder;
import de.bug0r.terminal.view.toolkit.item.impl.MainFrameBuilder;

public class ViewToolkit {

	public synchronized static ViewToolkit getInstance() {
		if ( instance == null ) instance = new ViewToolkit();
		return instance;
	}
	
	public Object getComponent(ViewComponent component) {
		Object componentObj = null;
		ComponentBuilder builder;
		if ( component != null && this.builderMap.containsKey(component) ) {
			builder = this.builderMap.get(component);
			componentObj = builder.create();
		}
		if (componentObj == null) componentObj = new NullBuilder().create();
		return componentObj;
	}
	
	private ViewToolkit() {
		this.builderMap = new HashMap<ViewComponent, ComponentBuilder>();
		this.builderMap.put(ViewComponent.MAIN_FRAME, new MainFrameBuilder());
		this.builderMap.put(ViewComponent.BOT_CONNECT_DLG, new ConnectionDialogBuilder());
	}
	
	private Map<ViewComponent, ComponentBuilder> builderMap;
	private static ViewToolkit instance;
}
