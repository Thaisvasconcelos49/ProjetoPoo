package Persistencia;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import Bancario.Cliente;

public class PersistenciaArquivo {
	ArrayList<Cliente> clientesCadastrados = new ArrayList<>();

	public PersistenciaArquivo() {
	carregarArquivo();
	}

	public void cadastrarCliente(Cliente c) {
	if (clientesCadastrados.contains(c))
	System.err.println("Cliente já cadastrado!");
	else {
	clientesCadastrados.add(c);
	salvarArquivo();
	}

	}

	public void listarCliente() {
	clientesCadastrados.forEach((n) -> System.out.println(n));
	}

	public Cliente listarCliente(String cpfConsulta) {
	Cliente temp = new Cliente(cpfConsulta);
	if(clientesCadastrados.contains(temp)) {
	int index = clientesCadastrados.indexOf(temp);
	temp = clientesCadastrados.get(index);
	return temp;
	}
	else
	return null;

	}

	public void removerCliente(Cliente c) {
	if(clientesCadastrados.contains(c)) {
	clientesCadastrados.remove(c);
	salvarArquivo();
	}
	System.out.println("Não foi possível remover");
	}

	public void salvarArquivo() {
	try {
	FileOutputStream fos = new FileOutputStream("dados");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(clientesCadastrados);
	oos.close();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

	public void carregarArquivo() {
	try {
	FileInputStream fis = new FileInputStream("dados");
	ObjectInputStream ois = new ObjectInputStream(fis);
	clientesCadastrados = (ArrayList<Cliente>)ois.readObject();
	} catch (IOException | ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}

	public void atualizarCliente(Cliente c) {
	if (clientesCadastrados.contains(c)) {
	int index = clientesCadastrados.indexOf(c);
	clientesCadastrados.set(index, c);
	salvarArquivo();
	}
	else {
	System.err.println("Cliente não encontrado.");
	}

	}

	}

