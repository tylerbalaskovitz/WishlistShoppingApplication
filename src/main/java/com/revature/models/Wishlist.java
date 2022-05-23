package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist")
public class Wishlist {

	//below are the columns names used when calling all products https://fakestoreapi.com/products 
	//NOTE: THe ID IS NOT SERIAL since there needs to be multiple instances of items to 
	//be stored for multiple users.
		
		//@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
		//@JoinColumn(name = "user.id")
		//private int wishlist_id;
		//for handling id of products in database
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//makes pk serial
		@Column
		private int id;
		@Column
		private int product_id;
		@Column
		private String title;
		@Column
		private String price;
		@Column
		private String description;
		@Column
		private String category;
		@Column
		private String image;
		@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
		@JoinColumn(name = "user_id") //THIS is how you establish FK/PK relationships
		public User user_fk;//this is the name of the foreign key to be put inside of the database. It will become an int field in the database.
		//the public user is referring to the class/model that hibernate will use to call and put data into the database.
		//the name attribute must be equal to the name of the PK in Directors in the DB. (in this case, director_id)
		//IMPORTANT NOTE: @Column will break this, because @JoinColumn already makes it a column
		//public User userId;
		
		 //THIS is how you establish FK/PK relationships
		//the name attribute must be equal to the name of the PK in Directors in the DB. (in this case, director_id)
		//IMPORTANT NOTE: @Column will break this, because @JoinColumn already makes it a column
		
		//there still needs to be code for referencing the user table via a FK
		//for users to have individual wishlists

		public Wishlist() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Wishlist(int id, int product_id, String title, String price, String description, String category,
				String image, User user_fk) {
			super();
			this.id = id;
			this.product_id = product_id;
			this.title = title;
			this.price = price;
			this.description = description;
			this.category = category;
			this.image = image;
			this.user_fk = user_fk;
		}
		public Wishlist(int product_id, String title, String price, String description, String category, String image,
				User user_fk) {
			super();
			this.product_id = product_id;
			this.title = title;
			this.price = price;
			this.description = description;
			this.category = category;
			this.image = image;
			this.user_fk = user_fk;
		}
		
		
		
		
	

}
	

