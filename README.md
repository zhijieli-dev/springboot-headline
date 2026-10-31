# SpringBoot Headline

Progetto backend per la gestione di notizie, sviluppato con Java e Spring Boot.

## Tecnologie utilizzate
- Java 21
- Spring Boot 4
- Spring MVC
- MyBatis-Plus
- MySQL 8
- Druid
- JWT

## Database

### `news_user`
Contiene le informazioni degli utenti registrati.
- `uid`: identificativo dell'utente
- `username`: nome utente
- `user_pwd`: password
- `nick_name`: nome visualizzato
- `version`: versione del record
- `is_deleted`: stato di eliminazione

### `news_headline`
Contiene le notizie pubblicate.
- `hid`: identificativo della notizia
- `title`: titolo
- `article`: contenuto della notizia
- `type`: identificativo della categoria
- `publisher`: identificativo dell'autore
- `page_views`: numero di visualizzazioni
- `create_time`: data di creazione
- `update_time`: data di aggiornamento
- `version`: versione del record
- `is_deleted`: stato di eliminazione

### `news_type`
Contiene le categorie delle notizie.
- `tid`: identificativo della categoria
- `tname`: nome della categoria
- `version`: versione del record
- `is_deleted`: stato di eliminazione

## API utenti

| Metodo | Endpoint | Descrizione |
|---|---|---|
| POST | `/user/login` | Effettua il login e genera un token JWT |
| GET | `/user/getUserInfo` | Recupera le informazioni dell'utente autenticato |
| POST | `/user/checkUserName` | Verifica se un nome utente è già utilizzato |
| POST | `/user/register` | Registra un nuovo utente |



