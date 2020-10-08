package org.vaadin.olli.views.helloworld;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.olli.views.main.Bean;
import org.vaadin.olli.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.olli.views.main.RestApi;

import java.util.List;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class GridView extends HorizontalLayout {

    private int totalAmountOfPages;
    private int itemsPerPage = 10;
    private int currentPageNumber = 1;

    public GridView() { ;
        Grid<Bean> grid = new Grid<>(Bean.class);

        totalAmountOfPages = RestApi.getPageCount(itemsPerPage);
        List<Bean> initialItems = RestApi.getPageItems(currentPageNumber, totalAmountOfPages, itemsPerPage);
        grid.setItems(initialItems);
        Button nextButton = new Button("Next page", e -> {
            if (currentPageNumber >= totalAmountOfPages) {
                return;
            }
            List<Bean> nextPageItems = RestApi.getPageItems(++currentPageNumber, totalAmountOfPages, itemsPerPage);
            grid.setItems(nextPageItems);
        });
        Button previousButton = new Button("Previous page", e -> {
            if (currentPageNumber <= 1) {
                return;
            }
            List<Bean> prevPageItems = RestApi.getPageItems(--currentPageNumber, totalAmountOfPages, itemsPerPage);
            grid.setItems(prevPageItems);
        });
        add(grid, previousButton, nextButton);
    }

}
