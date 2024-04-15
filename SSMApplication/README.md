# SSMApplication API

## How to run

### intellij

Run the SsmApplication.java file

The localhost url is ```localhost:8080/```

### JSON

#### Posts (POST request)

#### Replies (POST request)

```json
        {
            "replyID": 1,
            "postID": 1,
            "userID": 1,
            "replyText": "I am serious.",
            "likes": 0,
            "dislikes": 0,
            "createdOn": "2024-04-02",
            "updatedOn": null,
            "deleted": 0
        }
```


## Dependencies

[spotify-web-api-java](https://github.com/spotify-web-api-java/spotify-web-api-java)

## API Testing

- [Postman](https://www.postman.com/downloads/)

## See Also

- [Spotify API](https://developer.spotify.com/)
- [Setup of REST API](https://www.youtube.com/watch?v=oO6HPVRqGvg)
- [Setup Database Navigation](https://www.youtube.com/watch?v=V2bGKzvMQyc)
- [URL Value Extraction](https://javainfinite.com/spring-boot/http-get-ways-to-form-url/)
- [Postman Tutorial](https://learning.postman.com/docs/introduction/overview/)
- [Spring JSON](https://www.baeldung.com/spring-boot-json)
- [Spring HTTP Headers](https://www.baeldung.com/spring-rest-http-headers)
- [Spring Path Variables](https://www.baeldung.com/spring-pathvariable)
- [Spring Header Variables](https://www.baeldung.com/spring-rest-http-headers)
