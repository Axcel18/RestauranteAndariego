/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Controlador;

import DAO.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Marisol
 */
public class RestauranteAndariego {

    public static void main(String[] args) {
       try (Connection conn = ConexionBD.getConnection()) {
            if (conn != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            } else {
                System.out.println("Conexión fallida.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
