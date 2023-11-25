package eu.jpereira.trainings.designpatterns.creational.builder.model;

import eu.jpereira.trainings.designpatterns.creational.builder.HTMLReportBody;

import java.util.Iterator;

public class HTMLReportBuilder extends ReportBuilder {
    HTMLReportBody htmlReportBody = new HTMLReportBody();
    @Override
    public void buildReport() {
        report.setReportBody(htmlReportBody);
    }

    @Override
    public void buildCustomer(String name, String phone) {
        saleEntry.setCustomer(name,phone);

    }

    @Override
    public void printCustomer() {
       htmlReportBody.putContent("<span class=\"customerName\">");
       htmlReportBody.putContent(this.saleEntry.getCustomer().getName());
       htmlReportBody.putContent("</span><span class=\"customerPhone\">");
       htmlReportBody.putContent(this.saleEntry.getCustomer().getPhone());
       htmlReportBody.putContent("</span>");
    }

    @Override
    public void buildItem(String name, int quantity, double unitPrice) {
        saleEntry.addSoldItem(name, quantity, unitPrice);
    }

    @Override
    public void printItems() {
        htmlReportBody.putContent("<items>");

        Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
        while ( it.hasNext() ) {
            SoldItem soldEntry= it.next();
            htmlReportBody.putContent("<item><name>");
            htmlReportBody.putContent(soldEntry.getName());
            htmlReportBody.putContent("</name><quantity>");
            htmlReportBody.putContent(soldEntry.getQuantity());
            htmlReportBody.putContent("</quantity><price>");
            htmlReportBody.putContent(soldEntry.getUnitPrice());
            htmlReportBody.putContent("</price></item>");
        }
        htmlReportBody.putContent("</items>");
    }


}

