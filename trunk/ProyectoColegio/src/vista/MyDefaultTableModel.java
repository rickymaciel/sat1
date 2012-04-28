/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class MyDefaultTableModel extends DefaultTableModel
{
    public Vector getColumnIdentifiers() 
    {
            return columnIdentifiers;
    }
}
