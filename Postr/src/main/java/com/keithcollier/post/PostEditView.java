package com.keithcollier.post;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class PostEditView extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1841644217883282258L;
	

	// Reference to repo of posts
	private final PostRepo repo;
	
	//Reference to post being edited or created
	private Post post;
	
	//Fields for the post
	TextField posterName = new TextField("Name");
	TextField posterMessage = new TextField("Message");
	
	//buttons
	Button save = new Button("Save", FontAwesome.SAVE);
	Button cancel = new Button("Cancel", FontAwesome.TIMES_CIRCLE_O);
	Button delete = new Button("Delete", FontAwesome.TRASH_O);
	
	//CSS layout buttons
	
	CssLayout actions = new CssLayout(save, cancel, delete);
	
	Binder<Post> binder = new Binder<>(Post.class);

	@Autowired
	public PostEditView(PostRepo repo) {
		this.repo = repo;
		
		//adds components
		addComponents(posterName, posterMessage, actions);
		
		//binder using naming convention
		binder.bindInstanceFields(this);
		
		//config and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		
		//wire action button to save
		save.addClickListener(e -> repo.save(post));
		delete.addClickListener(e -> repo.delete(post));
		cancel.addClickListener(e -> editPost(post));
		setVisible(false);
	}
	
	//listen for changes
	public interface ChangeHandler {
		void onChange();
	}
	
	public final void editPost(Post post) {
		//if there is no post, make the component invisible
		if(post == null) {
			setVisible(false);
			return;
		}
		
		//store true if the post is not null
		final boolean isPersisted = post.getId() != null;
		
		if(isPersisted) {
			// find new entity to be edited
			post = repo.findOne(post.getId());
		}
		else {
			this.post = post;
		}
		
		//make cancel button properties to similarly named fields
		cancel.setVisible(isPersisted);
		
		//bind fields
		binder.setBean(this.post);
		setVisible(true);
		
		//ensure the form is visible
		save.focus();
		
		//select all text in the name field automatically
		posterName.selectAll();
	}
	
	public void setChangeHandler(ChangeHandler h) {
		//changeHandler is notified when save or delete is clicked
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}
	
}
