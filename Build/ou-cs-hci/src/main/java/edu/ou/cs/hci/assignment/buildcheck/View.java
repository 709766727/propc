//******************************************************************************
// Copyright (C) 2019-2023 University of Oklahoma Board of Trustees.
//******************************************************************************
// Last modified: Tue Jan 28 09:37:43 2020 by Chris Weaver
//******************************************************************************
// Major Modification History:
//
// 20190203 [weaver]:	Original file.
// 20190220 [weaver]:	Adapted from swingmvc to fxmvc.
// 20230112 [weaver]:	Adapted and simplified from prototypeA.
//
//******************************************************************************
//
//******************************************************************************

package edu.ou.cs.hci.assignment.buildcheck;

//import java.lang.*;
import java.util.ArrayList;
import java.net.URL;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.*;
import edu.ou.cs.hci.assignment.buildcheck.pane.*;

//******************************************************************************

/**
 * The <CODE>View</CODE> class.
 *
 * @author  Chris Weaver
 * @version %I%, %G%
 */
public final class View
{
	//**********************************************************************
	// Private Members
	//**********************************************************************

	// Master of the program, manager of the data, mediator of all updates
	private final Controller				controller;

	// Handlers
	private final WindowHandler			windowHandler;

	// Layout
	private final ArrayList<AbstractPane>	panes;

	//**********************************************************************
	// Constructors and Finalizer
	//**********************************************************************

	// Construct a scene and display it in a window (stage).
	public View(Controller controller, String name, double x, double y)
	{
		this.controller = controller;

		// Handle WINDOW_CLOSE_REQUESTs
		windowHandler = new WindowHandler();

		// Create a set of panes to include
		panes = new ArrayList<AbstractPane>();

		panes.add(new EditorPane(controller));

		// Create a tab pane with tabs for the set of included panes
		TabPane	tabPane = new TabPane();

		for (AbstractPane pane : panes)
			tabPane.getTabs().add(pane.createTab());

		// Create a scene with an initial size, and attach a style sheet to it
		Scene		scene = new Scene(tabPane, 240, 120);
		URL		url = View.class.getResource("View.css");
		String		surl = url.toExternalForm();

		scene.getStylesheets().add(surl);

		// Create a window/stage with a name and an initial position on screen
		Stage		stage = new Stage();

		stage.setOnHiding(windowHandler);
		stage.setScene(scene);
		stage.setTitle(name);
		stage.setX(x);
		stage.setY(y);
		stage.show();
	}

	//**********************************************************************
	// Public Methods (Controller)
	//**********************************************************************

	// The controller calls this method when it adds a view.
	// Set up the nodes in the view with data accessed through the controller.
	public void	initialize()
	{
		for (AbstractPane pane : panes)
			pane.initialize();
	}

	// The controller calls this method when it removes a view.
	// Unregister event and property listeners for the nodes in the view.
	public void	terminate()
	{
		for (AbstractPane pane : panes)
			pane.terminate();
	}

	// The controller calls this method whenever something changes in the model.
	// Update the nodes in the view to reflect the change.
	public void	update(String key, Object value)
	{
		for (AbstractPane pane : panes)
			pane.update(key, value);
	}

	//**********************************************************************
	// Inner Classes (Event Handlers)
	//**********************************************************************

	private final class WindowHandler
		implements EventHandler<WindowEvent>
	{
		public void	handle(WindowEvent e)
		{
			if (e.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST)
				controller.removeView(View.this);
		}
	}
}

//******************************************************************************
