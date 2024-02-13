package com.emart.entities;

public enum OrderStatus {
	
	    PENDING("Pending"),
	    PROCESSING("Processing"),
	    SHIPPED("Shipped"),
	    DELIVERED("Delivered"),
	    COMPLETED("Completed");

	    private String displayName;

	    OrderStatus(String displayName) {
	        this.displayName = displayName;
	    }

	    public String getDisplayName() {
	        return displayName;
	    }
}

