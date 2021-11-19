package com.example.E_Commerce.form;

import com.example.E_Commerce.model.Sale;
import com.example.E_Commerce.repository.SellRepository;

public class AtualizacaoStatusForm {


	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Sale atualizar(Long id, SellRepository sellRepository) {
		Sale sale = sellRepository.getOne(id);
		sale.setStatus(this.status);

		return sale;
	}

}
