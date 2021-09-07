package com.example.E_Commerce.form;

import com.example.E_Commerce.model.Venda;
import com.example.E_Commerce.repository.VendaRepository;

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
