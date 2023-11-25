package eu.jpereira.trainings.designpatterns.creational.builder.model;

import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBody;

import java.util.Iterator;

public class JSONReportBuilder extends ReportBuilder{
    private JSONReportBody JSONreportBody = new JSONReportBody();
    @Override
    public void buildReport() {
        report.setReportBody(JSONreportBody);
    }
    @Override
    public void buildCustomer(String name, String phone) {
        saleEntry.setCustomer(name,phone);
    }

    @Override
    public void printCustomer() {
        JSONreportBody.addContent("sale:{customer:{");
        JSONreportBody.addContent("name:\"");
        JSONreportBody.addContent(saleEntry.getCustomer().getName());
        JSONreportBody.addContent("\",phone:\"");
        JSONreportBody.addContent(saleEntry.getCustomer().getPhone());
        JSONreportBody.addContent("\"}");
    }

    @Override
    public void buildItem(String name, int quantity, double unitPrice) {
        saleEntry.addSoldItem(name, quantity, unitPrice);
    }

    @Override
    public void printItems() {
        JSONreportBody.addContent(",items:[");
        Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
        while (it.hasNext() ) {
            SoldItem item = it.next();
            JSONreportBody.addContent("{name:\"");
            JSONreportBody.addContent(item.getName());
            JSONreportBody.addContent("\",quantity:");
            JSONreportBody.addContent(String.valueOf(item.getQuantity()));
            JSONreportBody.addContent(",price:");
            JSONreportBody.addContent(String.valueOf(item.getUnitPrice()));
            JSONreportBody.addContent("}");
            if ( it.hasNext() ) {
                JSONreportBody.addContent(",");
            }

        }
        JSONreportBody.addContent("]}");

    }

}
