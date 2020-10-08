package org.vaadin.olli.views.about;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.olli.views.main.MainView;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
@CssImport("./styles/views/about/about-view.css")
@CssImport(value = "./styles/custom-upload.css", themeFor = "vaadin-upload")
public class AboutView extends Div {


    public AboutView() {
        MemoryBuffer buffer = new MemoryBuffer();
        Upload uploadWithFileList = new Upload(buffer);
        uploadWithFileList.setMaxFiles(5);
        uploadWithFileList.setDropLabel(new Span("This upload has a file list"));

        MemoryBuffer buffer2 = new MemoryBuffer();
        Upload uploadWithoutFileList = new Upload(buffer2);
        uploadWithoutFileList.setMaxFiles(5);
        uploadWithoutFileList.getElement().getThemeList().add("custom-upload");
        uploadWithoutFileList.setDropLabel(new Span("This upload doesn't have a file list"));

        add(uploadWithFileList, uploadWithoutFileList);
    }
}
