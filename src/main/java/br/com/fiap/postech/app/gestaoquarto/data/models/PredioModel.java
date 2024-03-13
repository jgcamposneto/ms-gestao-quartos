package br.com.fiap.postech.app.gestaoquarto.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "predio")
@Table(name = "predio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PredioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "predioModel", cascade = CascadeType.ALL)
    private List<QuartoModel> quartos;
}