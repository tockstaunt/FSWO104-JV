package com.keithcollier.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class PostView extends UI{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2846715858630815118L;

	private final PostRepo repo;
	
	private final PostEditView postEditView;
	
	final Grid<Post> grid;
	
	final TextField filter;
	
	private final Button addNewPostButton;
	
	@Autowired
	public PostView(PostRepo repo, PostEditView postEditView) {
		this.repo = repo;
		this.postEditView = postEditView;
		this.grid = new Grid<>(Post.class);
		this.filter = new TextField();
		this.addNewPostButton = new Button("New Post", FontAwesome.PLUS);
	}
	
	@Override
	protected void init(VaadinRequest request) {
		//build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewPostButton);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, postEditView);
		setContent(mainLayout);
		
		grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("id","firstName", "lastName");
		
		filter.setPlaceholder("filter by last name");
		
		//connect logic controller to  view
		
		//replace listing with filtered content when user changes filter
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listPost(e.getValue()));
		
		//Connect selected post to postEditView or hide
		grid.asSingleSelect().addValueChangeListener(e -> {
			postEditView.editPost(e.getValue());
		});
		
		// instantiate and edit new post when new button click
		addNewPostButton.addClickListener(e -> postEditView.editPost(new Post("","")));
		
		//listen to changes made by postEditView and refreash data from backend
		postEditView.setChangeHandler(() -> {
			postEditView.setVisible(false);;
			listPost(filter.getValue());
		});
		
		//initialize listing
		listPost(null);
	}
	
	void listPost(String filterText) {
		if(StringUtils.isEmpty(filterText)) {
			grid.setItems(repo.findAll());
		}
		else {
			grid.setItems(repo.findByPosterName(filterText));
		}
		
	}

}
