package com.noxtec.noxtec.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noxtec.noxtec.model.Contato;
import com.noxtec.noxtec.model.exception.ResourceNotFoundExcpition;
import com.noxtec.noxtec.repository.ContatoRepository;
import com.noxtec.noxtec.shared.ContatoDTO;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<ContatoDTO> getContatos() {
        List<Contato> contatos = repository.findAll();

        return contatos.stream()
                .map(contato -> new ModelMapper().map(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<ContatoDTO> getByIdContato(Integer id) {

        Optional<Contato> contato = repository.findById(id);

        if (contato.isEmpty()) {
            throw new ResourceNotFoundExcpition("Contato " + id + " não encontrado!");
        }
        ContatoDTO dto = new ModelMapper().map(contato.get(), ContatoDTO.class);

        return Optional.of(dto);

    }

    public List<ContatoDTO> getByName(String contatoNome) {
        List<Contato> contatos = repository.findByContatoNomeContaining(contatoNome);

        if (contatos.isEmpty()) {
            throw new ResourceNotFoundExcpition("Nome '" + contatoNome + "' não encontrado!");
        }

        List<ContatoDTO> dtos = contatos.stream()
                .map(contato -> new ModelMapper().map(contato, ContatoDTO.class))
                .collect(Collectors.toList());

        return dtos;
    }

    public List<ContatoDTO> getByTelefone(String contatoTelefone) {
        List<Contato> contatos = repository.findByContatoTelefoneContaining(contatoTelefone);

        if (contatos.isEmpty()) {
            throw new ResourceNotFoundExcpition("Nome '" + contatoTelefone + "' não encontrado!");
        }

        List<ContatoDTO> dtos = contatos.stream()
                .map(contato -> new ModelMapper().map(contato, ContatoDTO.class))
                .collect(Collectors.toList());

        return dtos;
    }

    public List<ContatoDTO> getByEmail(String contatoEmail) {
        List<Contato> contatos = repository.findByContatoEmailContaining(contatoEmail);

        if (contatos.isEmpty()) {
            throw new ResourceNotFoundExcpition("E-mail '" + contatoEmail + "' não encontrado!");
        }

        List<ContatoDTO> dtos = contatos.stream()
                .map(contato -> new ModelMapper().map(contato, ContatoDTO.class))
                .collect(Collectors.toList());

        return dtos;
    }

    public List<ContatoDTO> getByCelular(String contatoCelular) {
        List<Contato> contatos = repository.findByContatoCelularContaining(contatoCelular);

        if (contatos.isEmpty()) {
            throw new ResourceNotFoundExcpition("Celular '" + contatoCelular + "' não encontrado!");
        }

        List<ContatoDTO> dtos = contatos.stream()
                .map(contato -> new ModelMapper().map(contato, ContatoDTO.class))
                .collect(Collectors.toList());

        return dtos;
    }

    public ContatoDTO addContato(ContatoDTO contatoDTO) {
        ModelMapper mapper = new ModelMapper();
        Contato contato = mapper.map(contatoDTO, Contato.class);
        contato = repository.save(contato);
        return mapper.map(contato, ContatoDTO.class);
    }

    public void delete(Integer id) {
        Optional<Contato> contato = repository.findById(id);

        if (contato.isEmpty()) {
            throw new ResourceNotFoundExcpition(
                    "Contato com id: '" + id + "' não foi excluído, '" + id + "' contato não existe");
        }

        repository.deleteById(id);
    }

    public ContatoDTO update(Integer id, ContatoDTO contatoDTO) {
        Optional<Contato> existingContato = repository.findById(id);

        if (existingContato.isEmpty()) {
            throw new ResourceNotFoundExcpition("Contato com id: '" + id + "' não encontrado!");
        }

        contatoDTO.setId(id);
        ModelMapper mapper = new ModelMapper();
        Contato contato = mapper.map(contatoDTO, Contato.class);
        repository.save(contato);

        return mapper.map(contato, ContatoDTO.class);
    }
}
