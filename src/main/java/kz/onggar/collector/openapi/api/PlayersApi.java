/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package kz.onggar.collector.openapi.api;

import kz.onggar.collector.openapi.dto.Player;
import java.util.UUID;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-02T22:38:59.113612700+06:00[Asia/Almaty]")
@Validated
@Api(value = "players", description = "the players API")
public interface PlayersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /players
     * Create new player
     *
     * @param player  (required)
     * @return Successfully created a new player (status code 200)
     *         or Player with given steamId exists (status code 406)
     */
    @ApiOperation(value = "", nickname = "createNewPlayer", notes = "Create new player", response = Player.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully created a new player", response = Player.class),
        @ApiResponse(code = 406, message = "Player with given steamId exists") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/players",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Player> createNewPlayer(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Player player) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"steamId\" : \"steamId\", \"simpleMmr\" : 0, \"competitiveMmr\" : 6, \"relativeMmr\" : 1, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /players
     * Return all players
     *
     * @return Successfully returned a list of players (status code 200)
     */
    @ApiOperation(value = "", nickname = "getAllPlayers", notes = "Return all players", response = Player.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully returned a list of players", response = Player.class, responseContainer = "List") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/players",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Player>> getAllPlayers() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"steamId\" : \"steamId\", \"simpleMmr\" : 0, \"competitiveMmr\" : 6, \"relativeMmr\" : 1, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /players/{id}
     * Get player by id
     *
     * @param id  (required)
     * @return Successfully returned a player (status code 200)
     *         or Player not found (status code 404)
     */
    @ApiOperation(value = "", nickname = "getPlayerById", notes = "Get player by id", response = Player.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully returned a player", response = Player.class),
        @ApiResponse(code = 404, message = "Player not found") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/players/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Player> getPlayerById(@ApiParam(value = "",required=true) @PathVariable("id") UUID id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"steamId\" : \"steamId\", \"simpleMmr\" : 0, \"competitiveMmr\" : 6, \"relativeMmr\" : 1, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}