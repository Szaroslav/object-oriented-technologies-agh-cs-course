package command;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CommandRegistry {

	private ObservableList<Command> commandStack = FXCollections
			.observableArrayList();
	private ObservableList<Command> undoneCommandStack = FXCollections.observableArrayList();

	public void executeCommand(Command command) {
		command.execute();
		commandStack.add(command);
		undoneCommandStack.clear();
	}

	public void redo() {
		if (undoneCommandStack.isEmpty()) {
			return;
		}

		Command command = undoneCommandStack.remove(undoneCommandStack.size() - 1);
		command.redo();
		commandStack.add(command);
	}

	public void undo() {
		if (commandStack.isEmpty()) {
			return;
		}

		Command command = commandStack.remove(commandStack.size() - 1);
		command.undo();
		undoneCommandStack.add(command);
	}

	public ObservableList<Command> getCommandStack() {
		return commandStack;
	}
}
