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

## Funzionalità principali

- Registrazione e autenticazione degli utenti
- Generazione e verifica dei token JWT
- Controllo della disponibilità del nome utente
- Pubblicazione di nuove notizie
- Consultazione delle notizie con paginazione
- Ricerca delle notizie per titolo
- Filtraggio delle notizie per categoria
- Visualizzazione dei dettagli delle notizie
- Modifica ed eliminazione delle notizie
- Gestione delle categorie
- Conteggio delle visualizzazioni delle notizie

## Database

Il database MySQL contiene tre tabelle principali.

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

## API

### Gestione utenti

| Metodo | Endpoint | Parametri                         | Descrizione |
|---|---|-----------------------------------|---|
| POST | `/user/login` | `username`, `userPwd`             | Effettua il login e restituisce un token JWT |
| GET | `/user/getUserInfo` | Header: `token`                   | Recupera le informazioni dell'utente autenticato |
| POST | `/user/checkUserName` | `username`                        | Verifica se il nome utente è già utilizzato |
| POST | `/user/register` | `username`, `userPwd`, `nickName` | Registra un nuovo utente |
| GET | `/user/checkLogin` | Header: `token`                   | Verifica la validità del token |

### Gestione notizie

| Metodo | Endpoint | Parametri | Descrizione |
|---|---|---|---|
| POST | `/headline/publish` | `title`, `article`, `type`; Header: `token` | Pubblica una nuova notizia |
| POST | `/headline/findHeadlineById` | `hid` | Recupera una notizia tramite ID |
| POST | `/headline/update` | `hid`, `title`, `article`, `type` | Modifica una notizia |
| POST | `/headline/removeByHid` | `hid` | Elimina una notizia |

### Portale

| Metodo | Endpoint | Parametri                                 | Descrizione |
|---|---|-------------------------------------------|---|
| GET | `/portal/findAllTypes` |                                           | Recupera tutte le categorie |
| POST | `/portal/findNewsPage` | `keyWords`, `type`, `pageNum`, `pageSize` | Recupera le notizie filtrate e paginate |
| POST | `/portal/showHeadlineDetail` | `hid`                                     | Visualizza i dettagli di una notizia e aggiorna il numero di visualizzazioni |

### Esempi di richieste JSON

**Registrazione – `POST /user/register`**

```json
{
  "username": "mario",
  "userPwd": "password123",
  "nickName": "Mario"
}
```

**Login – `POST /user/login`**

```json
{
  "username": "mario",
  "userPwd": "password123"
}
```

**Ricerca notizie – `POST /portal/findNewsPage`**

```json
{
  "keyWords": "technology",
  "type": 2,
  "pageNum": 1,
  "pageSize": 10
}
```

Parametri della ricerca:

- `keyWords`: parola chiave utilizzata per la ricerca nel titolo.
- `type`: identificativo della categoria; il valore `0` indica tutte le categorie.
- `pageNum`: numero della pagina richiesta.
- `pageSize`: numero di notizie per pagina.

## Autenticazione

L'applicazione utilizza JWT (JSON Web Token) per gestire l'autenticazione degli utenti.

Dopo il login, il server restituisce un token che deve essere inviato nell'header HTTP `token` delle richieste agli endpoint protetti.

Un interceptor verifica la validità del token prima di consentire l'accesso alle operazioni protette.