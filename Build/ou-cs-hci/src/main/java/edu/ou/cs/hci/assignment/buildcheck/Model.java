//******************************************************************************
// Copyright (C) 2019-2023 University of Oklahoma Board of Trustees.
//******************************************************************************
// Last modified: Wed Feb 20 19:34:56 2019 by Chris Weaver
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
import java.util.HashMap;
import javafx.application.Platform;

//******************************************************************************

/**
 * The <CODE>Model</CODE> class.
 *
 * @author  Chris Weaver
 * @version %I%, %G%
 */
public final class Model
{
	//**********************************************************************
	// Private Members
	//**********************************************************************

	// Master of the program, manager of the data, mediator of all updates
	private final Controller				controller;

	// Easy, extensible way to store multiple simple, independent parameters
	private final HashMap<String, Object>	properties;

	//**********************************************************************
	// Constructors and Finalizer
	//**********************************************************************

	public Model(Controller controller)
	{
		this.controller = controller;

		properties = new HashMap<String, Object>();

		// STEP #0: Most modern user interfaces follow a Model-View-Controller
		// (MVC) design in which the data shown and edited in the various parts
		// of the UI (the views) are stored in a single place (the model) with
		// an intermediary (the controller) to manage and communicate changes.
		// This class provides a basic model in which the interactive state of a
		// user interface consists of a simple collection of named properties,
		// implemented as a set of <key, value> pairs in a hash table.

		// TODO #0: Create a property to represent an OU 4x4. Uncomment the line
		// below, change the property name (first argument) to "fourByFour", and
		// replace the default value (second argument) with your actual OU 4x4.
		//properties.put("CHANGE ME!", "xxxx####");
	}

	//**********************************************************************
	// Public Methods (Controller)
	//**********************************************************************

	public Object	getValue(String key)
	{
		return properties.get(key);
	}

	public void	setValue(String key, Object value)
	{
		if (properties.containsKey(key) &&
			properties.get(key).equals(value))
		{
			System.out.println("  model: value not changed");
			return;
		}

		Platform.runLater(new Updater(key, value));
	}

	public void	trigger(String name)
	{
		System.out.println("  model: (not!) calculating function: " + name);
	}

	//**********************************************************************
	// Inner Classes
	//**********************************************************************

	private class Updater
		implements Runnable
	{
		private final String	key;
		private final Object	value;

		public Updater(String key, Object value)
		{
			this.key = key;
			this.value = value;
		}

		public void	run()
		{
			properties.put(key, value);
			controller.update(key, value);
		}
	}
}

//******************************************************************************
