
package com.gdn.qa.training.model;

import java.util.HashMap;
import java.util.Map;

public class Category {

    private Categories categories;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
