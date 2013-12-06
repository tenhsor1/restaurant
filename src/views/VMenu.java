package views;

import java.awt.Color;
import java.awt.Font;
<<<<<<< HEAD
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class VMenu extends JPanel {
	public JButton getBtnMUsuarios() {
		return btnMUsuarios;
	}

=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import vectors.RoundedBorder;

public class VMenu extends JPanel {
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
	public JButton getBtnMVentas() {
		return btnMVentas;
	}

	public JButton getBtnMCompras() {
		return btnMCompras;
	}

	public JButton getBtnMEmpleados() {
		return btnMEmpleados;
	}


	public JButton getBtnMProductos() {
		return btnMProductos;
	}

	public JButton getBtnMPlatillos() {
		return btnMPlatillos;
	}

<<<<<<< HEAD
	private JButton btnMPlatillos,  btnMEmpleados, btnMCompras, btnMProductos, btnMVentas, btnMUsuarios;
=======
	private JButton btnMPlatillos,  btnMEmpleados, btnMCompras, btnMProductos, btnMVentas;
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
	private static final long serialVersionUID = 9014536977897804075L;

	/**
	 * Create the panel.
	 */
	public VMenu() {
		setForeground(Color.WHITE);
<<<<<<< HEAD
		setBackground(new Color(0, 74, 97));
		setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][]", "[fill]"));
		
		//Icono Platillos
		Image getPlatilloicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/platillo.png"));
		Image setPlatilloicn = getPlatilloicn.getScaledInstance(48, 48,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnPlatillo	= new ImageIcon(setPlatilloicn);//icono platillo
		//Icono PlatillosRO
		Image getPlatilloROicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/platilloRollOver.png"));
		Image setPlatilloROicn = getPlatilloROicn.getScaledInstance(48, 48,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnPlatilloRO	= new ImageIcon(setPlatilloROicn);//icono platillo
		//Icono Empleado
		Image getEmpleadoicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/empleado.png"));
		Image setEmpleadoicn = getEmpleadoicn.getScaledInstance(40, 48,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnEmpleado	= new ImageIcon(setEmpleadoicn);//icono platillo
		//Icono EmpleadoRO
		Image getEmpleadoROicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/empleadoRollOver.png"));
		Image setEmpleadoROicn = getEmpleadoROicn.getScaledInstance(40, 48,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnEmpleadoRO	= new ImageIcon(setEmpleadoROicn);//icono platillo
		//Icono Compras
		Image getComprasicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/compras.png"));
		Image setComprasicn = getComprasicn.getScaledInstance(48, 48,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnCompras	= new ImageIcon(setComprasicn);//icono platillo
		//Icono Compras
		Image getComprasROicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/comprasRO.png"));
		Image setComprasROicn = getComprasROicn.getScaledInstance(48, 48,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnComprasRO	= new ImageIcon(setComprasROicn);//icono platillo
		//Icono Ventas
		Image getVentasicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/ventas.png"));
		Image setVentasicn = getVentasicn.getScaledInstance(48, 48,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnVentas	= new ImageIcon(setVentasicn);//icono platillo
		//Icono Ventas
		Image getVentasROicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/ventasRO.png"));
		Image setVentasROicn = getVentasROicn.getScaledInstance(48, 48,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnVentasRO	= new ImageIcon(setVentasROicn);//icono platillo
				
				
		btnMProductos = new JButton("Productos");
		//Importante
		btnMProductos.setOpaque(false);
		btnMProductos.setContentAreaFilled(false);
		btnMProductos.setBorder(new EmptyBorder(0, 0, 0, 0));
		//Importante
		btnMProductos.setRolloverIcon(new ImageIcon(VMenu.class.getResource("/assets/ProductosRollOver.png")));
		btnMProductos.setIcon(new ImageIcon(VMenu.class.getResource("/assets/Productos.png")));
=======
		setBackground(Color.DARK_GRAY);
		setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][]", "[grow,fill]"));
		
		btnMProductos = new JButton("Productos");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		btnMProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMProductos.setToolTipText("Inventario de Productos");
		btnMProductos.setForeground(Color.WHITE);
<<<<<<< HEAD
		btnMProductos.setFont(new Font("Lato", Font.PLAIN, 11));
		//add(btnMProductos,"cell 0 0");
		
		btnMPlatillos = new JButton("Platillos");
		//Importante
		btnMPlatillos.setOpaque(false);
		btnMPlatillos.setContentAreaFilled(false);
		btnMPlatillos.setBorder(new EmptyBorder(0, 0, 0, 0));
		//Importante
		btnMPlatillos.setRolloverIcon(icnPlatilloRO);
		btnMPlatillos.setIcon(icnPlatillo);
=======
		btnMProductos.setBackground(new Color(0, 153, 102));
		btnMProductos.setFont(new Font("Lato", Font.PLAIN, 11));
		btnMProductos.setBorder(new RoundedBorder(5));
		add(btnMProductos, "cell 0 0");
		
		btnMPlatillos = new JButton("Platillos");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		btnMPlatillos.setToolTipText("Inventario de Platillos");
		btnMPlatillos.setForeground(Color.WHITE);
		btnMPlatillos.setBackground(new Color(0, 153, 102));
		btnMPlatillos.setFont(new Font("Lato", Font.PLAIN, 11));
<<<<<<< HEAD
		//add(btnMPlatillos, "cell 5 0");
		
		btnMEmpleados = new JButton("Empleados");
		//Importante
		btnMEmpleados.setOpaque(false);
		btnMEmpleados.setContentAreaFilled(false);
		btnMEmpleados.setBorder(new EmptyBorder(0, 0, 0, 0));
		//Importante
		btnMEmpleados.setRolloverIcon(icnEmpleadoRO);
		btnMEmpleados.setIcon(icnEmpleado);
=======
		btnMPlatillos.setBorder(new RoundedBorder(5));
		add(btnMPlatillos, "cell 5 0");
		
		btnMEmpleados = new JButton("Empleados");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		btnMEmpleados.setToolTipText("Inventario de Empleados");
		btnMEmpleados.setForeground(Color.WHITE);
		btnMEmpleados.setBackground(new Color(0, 153, 102));
		btnMEmpleados.setFont(new Font("Lato", Font.PLAIN, 11));
<<<<<<< HEAD
		//add(btnMEmpleados, "cell 10 0");
		
		btnMVentas = new JButton("Ventas");
		//Importante
		btnMVentas.setOpaque(false);
		btnMVentas.setContentAreaFilled(false);
		btnMVentas.setBorder(new EmptyBorder(0, 0, 0, 0));
		//Importante
		btnMVentas.setToolTipText("Lista de Ventas");
		btnMVentas.setForeground(Color.WHITE);
		btnMVentas.setBackground(new Color(0, 153, 102));
		btnMVentas.setFont(new Font("Lato", Font.PLAIN, 11));
		btnMVentas.setIcon(icnVentas);
		btnMVentas.setRolloverIcon(icnVentasRO);
		//add(btnMVentas, "cell 15 0");
		
		btnMCompras = new JButton("Compras");
		//Importante
		btnMCompras.setOpaque(false);
		btnMCompras.setContentAreaFilled(false);
		btnMCompras.setBorder(new EmptyBorder(0, 0, 0, 0));
		//Importante
=======
		btnMEmpleados.setBorder(new RoundedBorder(5));
		add(btnMEmpleados, "cell 10 0");
		
		btnMCompras = new JButton("Compras");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		btnMCompras.setToolTipText("Inventario de Compras");
		btnMCompras.setForeground(Color.WHITE);
		btnMCompras.setBackground(new Color(0, 153, 102));
		btnMCompras.setFont(new Font("Lato", Font.PLAIN, 11));
<<<<<<< HEAD
		btnMCompras.setIcon(icnCompras);
		btnMCompras.setRolloverIcon(icnComprasRO);
		//add(btnMCompras, "cell 20 0");
		
		btnMUsuarios = new JButton("Usuarios");
		//add(btnMUsuarios, "cell 25 0");
		
=======
		btnMCompras.setBorder(new RoundedBorder(5));
		add(btnMCompras, "cell 14 0");
		
		btnMVentas = new JButton("Ventas");
		btnMVentas.setToolTipText("Lista de Ventas");
		btnMVentas.setForeground(Color.WHITE);
		btnMVentas.setBackground(new Color(0, 153, 102));
		btnMVentas.setFont(new Font("Lato", Font.PLAIN, 11));
		btnMVentas.setBorder(new RoundedBorder(5));
		add(btnMVentas, "cell 19 0");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
	}

}
