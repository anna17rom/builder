/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.creational.builder.model;

import java.util.Iterator;

import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

/**
 * @author jpereira
 *
 */
public class ReportAssembler {

	private ReportBuilder reportBuilder;

	public void setReportBuilder(ReportBuilder rb){
		reportBuilder = rb;
	}

	public Report getReport(){
		return reportBuilder.getReport();
	}

	public void addSoldItem(String name, int quantity, double unitPrice){
		reportBuilder.buildItem(name,quantity,unitPrice);
	}

	public void addCustomer(String name, String phone){
		reportBuilder.buildCustomer(name, phone);
	}

    public void constructReport(){
		reportBuilder.createNewReport();
		reportBuilder.printCustomer();
		reportBuilder.printItems();
		reportBuilder.buildReport();

	}

}

