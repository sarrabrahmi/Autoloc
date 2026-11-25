package tn.esprit.autoloc.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.DTO.ReservationResponseDto;
import tn.esprit.autoloc.Entities.reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "idReservation", target = "id")
    @Mapping(source = "client.nom", target = "nomClient")
    @Mapping(source = "client.prenom", target = "prenomClient")
    @Mapping(source = "vehicule.marque", target = "marque")
    @Mapping(source = "vehicule.modele", target = "modele")
    @Mapping(source = "vehicule.immatriculation", target = "immatriculation")
    ReservationResponseDto toResponseDto(reservation entity);
}