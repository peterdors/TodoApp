package todolist;

import userinterface.TodoUi;

public class Main 
{

	public static void main(String[] args) 
	{
		TodoList todoList = new TodoList();
		
		TodoUi todoUi = new TodoUi(todoList);
	}

}
