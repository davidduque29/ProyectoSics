/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.util;


/**
 consulta probada en MYSQL
select 	st.material, so.cantidad,  so.tipo, 
		 so.fechaCreacion 
from 	produccion as pr inner join 
		sobrante as so on so.codProduccion = pr.idProduccion inner join 
		stockmaterial as st on st.idStockMaterial = so.codStockMaterial 
-- ORDER BY pr.proceso
where so.fechaCreacion between '2017-01-01' and '2017-06-01'
 */
public class ReporteSobrante {
    // Se crea una clase auxiliar
    // Se declaran las variables o campos que se van a imprimir en el reporte
    // Se encapsula 
    // private String material;
    private int cantidad;
    private String material;

//    public String getMaterial() {
//        return material;
//    }
//
//    public void setMaterial(String material) {
//        this.material = material;
//    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

  
    
    
}
