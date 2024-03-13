package br.com.fiap.postech.gestaoquarto.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class Predio {

    private Long id;
    private List<Quarto> quartos;
}
