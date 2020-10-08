package org.vaadin.olli.views.main;

import java.util.ArrayList;
import java.util.List;

public class RestApi {

    public static List<Bean> getPageItems(int pageNumber, int pageCount, int itemsPerPage) {
        if (pageNumber < 1 || pageNumber > pageCount) {
            return null;
        }
        List<Bean> result = new ArrayList<>();
        for(int i = 0; i < itemsPerPage; i++) {
            Bean bean = new Bean();
            bean.setName("Page " + pageNumber + " item " + i);
            result.add(bean);
        }
        return result;
    }

    public static int getPageCount(int itemsPerPage) {
        return 10;
    }
}
