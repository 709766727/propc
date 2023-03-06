//******************************************************************************
// Copyright (C) 2019-2023 University of Oklahoma Board of Trustees.
//******************************************************************************
// Last modified: Tue Jan 28 09:28:34 2020 by Chris Weaver
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

package edu.ou.cs.hci.assignment.buildcheck.pane;

//import java.lang.*;
import java.util.ArrayList;
import javafx.animation.*;
import javafx.beans.value.ObservableValue;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.util.Callback;
import edu.ou.cs.hci.assignment.buildcheck.Controller;
import edu.ou.cs.hci.resources.Resources;

//******************************************************************************

/**
 * The <CODE>EditorPane</CODE> class.
 *
 * @author  Chris Weaver
 * @version %I%, %G%
 */
public final class EditorPane extends AbstractPane
{
	//**********************************************************************
	// Private Class Members
	//**********************************************************************

	private static final String	NAME = "Build Check";
	private static final String	HINT = "Editor Pane for Build Check";

	//**********************************************************************
	// Private Members
	//**********************************************************************

	// Layout (widgets)
	private TextField				textField;

	// Handlers
	private final ActionHandler	actionHandler;

	//**********************************************************************
	// Constructors and Finalizer
	//**********************************************************************

	public EditorPane(Controller controller)
	{
		super(controller, NAME, HINT);

		actionHandler = new ActionHandler();

		setBase(buildPane());
	}

	//**********************************************************************
	// Public Methods (Controller)
	//**********************************************************************

	// STEP #4: This method initializes the widgets in the layout with the
	// data attribute values from the model when the UI first appears. The
	// controller calls this method when it adds a view. The method goes through
	// the controller to access any data needed from the model.
	public void	initialize()
	{
		// TODO #4: Uncomment the following line to initialize the widget.
		//textField.setText((String)controller.get("fourByFour"));
	}

	// STEP #5: This method unregisters each widget from any event listeners
	// and/or property change handlers it was registered with in STEP #2. The
	// controller calls this method when it removes a view.
	public void	terminate()
	{
		// TODO #5: Uncomment the following line to terminate the widget.
		//textField.setOnAction(null);
	}

	// STEP #6: This method updates widgets whenever data in the model changes.
	// The model calls this method (via the controller) whenever an attribute
	// value changes. The method updates any widgets that display (or otherwise
	// depend on) the value of the attribute of the given key (name).
	public void	update(String key, Object value)
	{
		//System.out.println("update " + key + " to " + value);

		// TODO #6: Uncomment the following four lines to update the widget when
		// the corresponding property has changed.
		//if ("fourByFour".equals(key))
		//{
		//	textField.setText((String)value);
		//}
	}

	//**********************************************************************
	// Private Methods (Layout)
	//**********************************************************************

	// STEP #3: This method organizes the widgets, labels, etc. in the design
	// into a hierarchical layout of panes. (See the javafx.scene.layout package
	// in the JavaFX APIs to learn about available pane classes. Commonly used
	// layout classes include BorderPane, GridPane, HBox, VBox, and StackPane.) 
	// (Note: There are no TODOs for this step.)
	private Pane	buildPane()
	{
		// Layout the widgets in a vertical flow with small gaps between them.
		FlowPane	pane = new FlowPane(Orientation.VERTICAL, 8.0, 8.0);

		pane.setAlignment(Pos.TOP_LEFT);

		// Call the method from STEP #1 to create a pane to add to the layout.
		pane.getChildren().add(createTextField());

		return pane;
	}

	//**********************************************************************
	// Private Methods (Widget Pane Creators)
	//**********************************************************************

	// STEP #1: Layout code is usually straightforward but long and detailed.
	// Methods like this one help by cleanly encapsulating the layout code for
	// particular parts. They also include code to register the widgets they
	// create with appropriate event listeners and/or property change handlers.
	// (See the javafx.scene.control package in the JavaFX APIs to learn about
	// the types of events and properties used by each widget type.) This method
	// creates a single text field wrapped inside a titled pane (as an easy
	// means of labeling), and registers the text field with an action handler.
	private Pane	createTextField()
	{
		// Note: textField is declared as a class member (see above) rather than
		// a local variable because other methods need to reference it too.
		textField = new TextField();

		// TODO #1a: Uncomment the following line to configure the widget.
		//textField.setPrefColumnCount(8);

		// TODO #1b: Uncomment the following line to register the widget.
		//textField.setOnAction(actionHandler);

		// TODO #1c: Change the string to an appropriate label for the widget.
		return createTitledPane(textField, "CHANGE ME!");

		// Note: For just one widget, actionHandler could have been declared as
		// a local variable. In the future we'll reuse it for multiple widgets,
		// however, so it needs to be a declared as a class member, and also
		// instantiated only once. The constructor is a good place for that.
	}

	//**********************************************************************
	// Inner Classes (Event Handlers)
	//**********************************************************************

	// STEP #2: Inner classes like this one are needed to handle events
	// triggered by interactions in widgets. Each class implements a handling
	// method that takes the modified information from the source widget and
	// uses it to update corresponding data in the model (via the controller).
	// This class handles action events triggered by changes to the text in the
	// text field, such as when a user hits return after changing the text.
	private final class ActionHandler
		implements EventHandler<ActionEvent>
	{
		public void	handle(ActionEvent e)
		{
			Object	source = e.getSource();

			// TODO #2: Uncomment the following two lines to update the model.
			//if (source == textField)
			//	controller.set("fourByFour", textField.getText());
		}
	}
}

//******************************************************************************
