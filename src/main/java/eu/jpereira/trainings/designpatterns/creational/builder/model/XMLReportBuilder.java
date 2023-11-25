package eu.jpereira.trainings.designpatterns.creational.builder.model;

import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

import java.util.Iterator;

public class XMLReportBuilder extends ReportBuilder {

    XMLReportBody xmlReportBody = new XMLReportBody();
    @Override
    public void buildReport() {
        report.setReportBody(xmlReportBody);
    }

    @Override
    public void buildCustomer(String name, String phone) {
        saleEntry.setCustomer(name, phone);

    }

    @Override
    public void printCustomer() {
        xmlReportBody.putContent("<sale><customer><name>");
        xmlReportBody.putContent(this.saleEntry.getCustomer().getName());
        xmlReportBody.putContent("</name><phone>");
        xmlReportBody.putContent(this.saleEntry.getCustomer().getPhone());
        xmlReportBody.putContent("</phone></customer>");

    }

    @Override
    public void buildItem(String name, int quantity, double unitPrice) {
        saleEntry.addSoldItem(name, quantity, unitPrice);

    }

    @Override
    public void printItems() {
        xmlReportBody.putContent("<items>");
        Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
        while ( it.hasNext() ) {
            SoldItem soldEntry= it.next();
            xmlReportBody.putContent("<item><name>");
            xmlReportBody.putContent(soldEntry.getName());
            xmlReportBody.putContent("</name><quantity>");
            xmlReportBody.putContent(soldEntry.getQuantity());
            xmlReportBody.putContent("</quantity><price>");
            xmlReportBody.putContent(soldEntry.getUnitPrice());
            xmlReportBody.putContent("</price></item>");
        }
        xmlReportBody.putContent("</items></sale>");

    }
}


