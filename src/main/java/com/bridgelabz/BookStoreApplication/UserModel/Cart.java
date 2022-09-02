package com.bridgelabz.BookStoreApplication.UserModel;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.bridgelabz.BookStoreApplication.Model.BookStore;



@Entity
public class Cart {
	 @Id  
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int cartId;
	 
	

	 @OneToOne(cascade = CascadeType.ALL)
	    private User user;

	    @OneToMany(cascade = CascadeType.ALL , mappedBy = "cart")
	    private List<BookStore> bookStore;

		public int getCartId() {
			return cartId;
		}

		public void setCartId(int cartId) {
			this.cartId = cartId;
		}
}


