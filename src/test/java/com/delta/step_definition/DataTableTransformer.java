package com.delta.step_definition;

import java.util.Locale;

import java.util.Map;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

public class DataTableTransformer implements TypeRegistryConfigurer {

	public Locale locale() {
		return Locale.ENGLISH;
	}

	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		// typeRegistry.defineDataTableType(new DataTableType(User.class,
		typeRegistry.defineDataTableType(new DataTableType(BeanClass.class,
				// new TableEntryTransformer<User>() {
				new TableEntryTransformer<BeanClass>() {

					@Override

//            public User transform(Map<String, String> row) throws Throwable{
//                          
//                            String firstName = row.get("First Name");
//                            String lastName = row.get("Last Name");
//                            String address = row.get("Address");
//                            String city = row.get("City");
//                            String zip = row.get("Zip");
//                            String phone = row.get("Phone");
//                            String password = row.get("Password");
//                            return new User(firstName, lastName, address, password, city, zip, phone);
//                        }
//                    }));
//
//					public ShoppingCart transform(Map<String, String> row) throws Throwable {
//						String description = row.get("Description");
//						String unitPrice = row.get("Unit price");
//						String quantity = row.get("Quantity");
//						String totalBefore = row.get("Product Total");
//						String totalAfter = row.get("Total After fees");
//
//						return new ShoppingCart(description, unitPrice, quantity, totalBefore, totalAfter
//
//				);
//					}
//				}));

	}
}}