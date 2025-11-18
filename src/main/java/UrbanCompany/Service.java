package UrbanCompany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Service {
    String name;
    double price;
    abstract void performService();
}
