package sample;

import java.time.LocalDate;

public class Goods implements Cloneable
{
    private String name;
    private int price;
    private LocalDate deliveryDate;
    private int number;

    public Goods(String name, int price, LocalDate deliveryDate, int number)
    {
        this.name = name;
        this.price = price;
        this.deliveryDate = deliveryDate;
        this.number = number;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void setDeliveryDate(LocalDate deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }

    public LocalDate getDeliveryDate()
    {
        return deliveryDate;
    }

    public int getNumber()
    {
        return number;
    }

    @Override
    protected Goods clone()
    {
        Goods goods = new Goods(name, price, deliveryDate, number);
        return goods;
    }
}
