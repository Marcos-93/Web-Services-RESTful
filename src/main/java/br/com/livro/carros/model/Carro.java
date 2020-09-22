package br.com.livro.carros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String tipo;
 private String nome;
 private String descricao;
 private String urlFoto;
 private String urlVideo;
 private String latitude;
 private String longitude;

 public Carro() {
 }
 public Carro(String tipo, String nome, String descricao) {
  this.tipo = tipo;
  this.nome = nome;
  this.descricao = descricao;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getTipo() {
  return tipo;
 }

 public void setTipo(String tipo) {
  this.tipo = tipo;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public String getDescricao() {
  return descricao;
 }

 public void setDescricao(String descricao) {
  this.descricao = descricao;
 }

 public String getUrlFoto() {
  return urlFoto;
 }

 public void setUrlFoto(String urlFoto) {
  this.urlFoto = urlFoto;
 }

 public String getUrlVideo() {
  return urlVideo;
 }

 public void setUrlVideo(String urlVideo) {
  this.urlVideo = urlVideo;
 }

 public String getLatitude() {
  return latitude;
 }

 public void setLatitude(String latitude) {
  this.latitude = latitude;
 }

 public String getLongitude() {
  return longitude;
 }

 public void setLongitude(String longitude) {
  this.longitude = longitude;
 }

 @Override
 public String toString() {
  return "Carro{" +
          "id=" + id +
          ", tipo='" + tipo + '\'' +
          ", nome='" + nome + '\'' +
          ", desc='" + descricao + '\'' +
          ", urlFoto='" + urlFoto + '\'' +
          ", urlVideo='" + urlVideo + '\'' +
          ", latitude='" + latitude + '\'' +
          ", longitude='" + longitude + '\'' +
          '}';
 }
}
