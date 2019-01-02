package userinterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import todolist.TodoList;

public class TodoUi 
{
	private TodoList todoList;
	JTextField textField;
	JButton submitButton;
	JPanel todoPanel, listPanel;
	JFrame frame;
	
	public TodoUi(TodoList todoList)
	{
		this.todoList = todoList;
		
		initComponents();
		
		todoList.setTodoUi(this);
	}
	
	public void initComponents()
	{
		initFrameComponents();
	}
	
	public void initFrameComponents()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		
		initPanelComponents(frame);
		
	}
	
	public void initPanelComponents(JFrame frame)
	{
		todoPanel = new JPanel();
		listPanel = new JPanel();
		
		todoPanel.setBorder(BorderFactory.createTitledBorder("TODO"));
		listPanel.setBorder(BorderFactory.createTitledBorder("List of TODO Items"));
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		listPanel.add(Box.createRigidArea(new Dimension(0,5)));
		
		initButtonComponents(frame, todoPanel);
		initTextBoxComponents(todoPanel);
		
		frame.add(todoPanel, BorderLayout.NORTH);
		frame.add(listPanel);
		
	}
	
	public void initButtonComponents(JFrame frame, JPanel todoPanel)
	{
		submitButton = new JButton("Submit");

		submitButton.addActionListener(new SubmitButtonListener());
		
		todoPanel.add(submitButton);
	}

	private void initTextBoxComponents(JPanel todoPanel)
	{
		textField = new JTextField();
		todoPanel.add(textField, JPanel.LEFT_ALIGNMENT);
	}
	
	private class SubmitButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ae) 
		{
			// changes
	
		}
		
	}
	
}

