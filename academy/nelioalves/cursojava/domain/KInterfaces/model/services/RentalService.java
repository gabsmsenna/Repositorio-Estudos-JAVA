package academy.nelioalves.cursojava.domain.KInterfaces.model.services;

import academy.nelioalves.cursojava.domain.KInterfaces.model.entities.CarRental;
import academy.nelioalves.cursojava.domain.KInterfaces.model.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;
    private TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        double minutes = Duration.between(carRental.getStart(), carRental.getEnd()).toMinutes();
        double hours = minutes / 60.0;
        double basicPayment;
        if (hours <= 12) {
            basicPayment = pricePerHour *Math.ceil(hours); //ESTE MÉTODO ESTÁ PEGANDO A FRAÇÃO DE HORAS E ARREDONANDO PARA CIMA
        } else {
            basicPayment = pricePerDay * Math.ceil(hours / 24);
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }
}