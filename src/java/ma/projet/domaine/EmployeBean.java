/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.domaine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import ma.projet.beans.Service;
import ma.projet.beans.Employe;
import ma.projet.service.EmployeService;
import ma.projet.service.ServiceService;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;


import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;


@ManagedBean(name = "employeBean")
public class EmployeBean {
    
    private Service service;

    private Employe employe;
    
    private List<Employe> employes;

    private ServiceService serviceService;
    private EmployeService employeService;
    private static ChartModel barModel;

    private List<Employe> employesBetweenDates;
    private Employe selectedChef;


    

  

   

    public EmployeBean() {
        employe = new Employe();
         selectedChef = new Employe();
        selectedChef=new Employe();
        employeService = new EmployeService();
        employe.setService(new Service());
        serviceService = new ServiceService();
    

    }
 

       public Employe getSelectedChef() {
        return selectedChef;
    }

    public void setSelectedChef(Employe selectedChef) {
        this.selectedChef = selectedChef;
    }

    
    
    

    public List<Employe> getEmployes() {
        if (employes == null) {
            employes = employeService.getAll();
        }
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public EmployeService getEmployeService() {
        return employeService;
    }

    public void setEmployeService(EmployeService employeService) {
        this.employeService = employeService;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

   

    public String onCreateAction() {
        employe.setChef(selectedChef);
         employe.setChief(true);
        employeService.create(employe);
        employe = new Employe();
        return null;
    }

   public String onDeleteAction() {

        employeService.delete(employeService.getById(employe.getId()));
        return null;
    }
    
    
    public List<Employe> serviceLoad() {
        for (Employe e : employeService.getAll()) {
            if (e.getService().equals(service)) {
                employes.add(e);
            }
        }
        return employes;

    }

    public void load() {
        System.out.println(service.getNom());
        service = serviceService.getById(service.getId());
        getEmployes();
    }

    public void onEdit(RowEditEvent event) {
        employe = (Employe) event.getObject();
        Service newservice = serviceService.getById(this.employe.getService().getId());
        employe.setService(newservice);
        employeService.update(employe);
        
    }
    

    


    public void onCancel(RowEditEvent event) {
    }

    public ChartModel getBarModel() {
        return barModel;
    }

    public ChartModel initBarModel() {
        CartesianChartModel model = new CartesianChartModel();
        ChartSeries employes = new ChartSeries();
        employes.setLabel("employes");
        model.setAnimate(true);
        for (Object[] m : employeService.nbemploye()) {
            employes.set(m[1], Integer.parseInt(m[0].toString()));
        }
        model.addSeries(employes);

        return model;
    }

  

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Employe> getEmployesBetweenDates() {
        return employesBetweenDates;
    }

    public void setEmployesBetweenDates(List<Employe> employesBetweenDates) {
        this.employesBetweenDates = employesBetweenDates;
    }
    
    



}
