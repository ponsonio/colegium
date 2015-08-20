package org.domain.colegium.session.bean;

import java.io.Serializable;

import org.jboss.seam.annotations.Name;

@Name("column")
public class Column implements Serializable{
		
		private String name;
		private int id;
		
		public Column(String name, int id) {
			super();
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
}
