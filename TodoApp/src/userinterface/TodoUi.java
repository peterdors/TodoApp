package userinterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.ArrayList;



import todolist.TodoList;

public class TodoUi 
{
	ArrayList<JPanel> panelList;
	private TodoList todoList;
	JTextField textField;
	JButton addButton, remButton;
	JPanel mainPanel, todoPanel, listPanel;
	JFrame frame;
	
	public TodoUi(TodoList todoList)
	{
		this.todoList = todoList;
		panelList = new ArrayList<>();
		
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
		
		initPanelComponents(frame);
		
		frame.setLayout(new FlowLayout());
		
		frame.setVisible(true);
		
	}
	
	public void initPanelComponents(JFrame frame)
	{	
		// Initialize the JPanel's.
		mainPanel = new JPanel();
		todoPanel = new JPanel();
		listPanel = new JPanel();
		// mainPanel settings.
		mainPanel.setBorder(BorderFactory.createTitledBorder("Title of Main Panel"));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		// todoPanel settings.
		todoPanel.setLayout(new GridBagLayout());
		todoPanel.setPreferredSize(new Dimension(500, 100));
		todoPanel.setBorder(BorderFactory.createTitledBorder("TODO"));
		// listPanel settings.
		listPanel.setLayout(new GridLayout(0, 1));
		listPanel.setPreferredSize(new Dimension(500, 400));
		listPanel.setBorder(BorderFactory.createTitledBorder("List of TODO Items"));

		initTextBoxComponents(todoPanel);
		initButtonComponents(todoPanel);
		
		mainPanel.add(todoPanel);
		mainPanel.add(listPanel);
		
		mainPanel.revalidate();
		
		frame.add(mainPanel);
	}
	
	public void initButtonComponents(JPanel todoPanel)
	{
		addButton = new JButton("Add");
		remButton = new JButton("Remove");
		
		addButton.setPreferredSize(new Dimension(70, 20));
		remButton.setPreferredSize(new Dimension(100, 20));
		
		addButton.addActionListener(new AddActionListener());
		remButton.addActionListener(new RemActionListener());

		todoPanel.add(addButton);
		todoPanel.add(remButton);
		
		todoPanel.revalidate();
	}

	private void initTextBoxComponents(JPanel todoPanel)
	{
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(70, 20));
		
		todoPanel.add(textField);
	}
	
	private class AddActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ae) 
		{
			String getText = textField.getText();
			JPanel panel = new JPanel();
			JLabel label = new JLabel(getText);
			
			panel.add(label);
			
			panelList.add(panel);
			
			listPanel.add(panel);
			listPanel.validate();
			listPanel.repaint();
		}
		
	}	
	
	private class RemActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ae) 
		{
			int index = (panelList.size() > 0) ? (panelList.size() - 1) : 0; 
			try 
			{
				panelList.get(index).removeAll();
				
				panelList.subList(index, panelList.size()).clear();
			} 
			catch (Exception e)
			{
				System.out.println("Empty list");
			}
			
			listPanel.validate();
			listPanel.repaint();
		}
		
	}
	
}

