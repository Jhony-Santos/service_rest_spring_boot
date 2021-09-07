package com.example.sistemaControle.form;




import com.example.sistemaControle.model.Venda;
import com.example.sistemaControle.repository.VendaRepository;

public class AtualizacaoStatusForm {


	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Venda atualizar(Long id, VendaRepository vendaRepository) {
		Venda venda = vendaRepository.getOne(id);
		venda.setStatus(this.status);

		return venda;
	}

}
