package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist")
public class Wishlist {

	//below are the columns names used when calling all products https://fakestoreapi.com/products 
	//NOTE: THe ID IS NOT SERIAL since there needs to be multiple instances of items to 
	//be stored for multiple users.
	
	

		
	

		@Column
		private int id;
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
		
		
		
		//there still needs to be code for referencing the user table via a FK
		//for users to have individual wishlists.
		
		
		



		

		public int getId() {
			return id;
		}

		public Wishlist(int id, String title, String price, String description, String category, String image) {
			super();
			this.id = id;
			this.title = title;
			this.price = price;
			this.description = description;
			this.category = category;
			this.image = image;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}



		@Override
		public String toString() {
			return "User [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description
					+ ", category=" + category + ", image=" + image + "]";
		}
		
		
}
	

