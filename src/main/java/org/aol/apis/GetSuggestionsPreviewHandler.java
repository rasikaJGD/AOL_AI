package org.aol.apis;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.aol.models.*;
import org.aol.models.enums.PostContext;
import org.aol.models.enums.PostStatus;
import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GetSuggestionsPreviewHandler implements RequestHandler<GetSuggestionsPreviewRequest, SuggestionsPreviewResponse> {

    @Override
    public SuggestionsPreviewResponse handleRequest(GetSuggestionsPreviewRequest input, Context context) {
        Post originalPost = Post.builder().imageLink(input.getImageS3URL())
                .textSuggestion(input.getText())
                .postStatus(PostStatus.ORIGINAL)
                .postMetadata(PostMetadata.builder().postContext(PostContext.SKY).Timestamp(DateTime.now()).build())
                .build();


        // Fetch the Prompt from Dynamo DB here.

        // Invoke ChatGPT API call here

        // Fetch images if required here

        // Combine output and create Generated Post object
//        GeneratedPosts generatedPosts = GeneratedPosts.builder()
//                .PostId_UserId("123_456")
//                .PostContext_Timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
//                .GeneratedPosts(postList)
//                .UserInput(input)
//                .build();


        // Save Generated Post to Dynamo DB here

        // Return the Generated Post to the client here
        List<Post> postList = new ArrayList<>();
        postList.add(originalPost); // Replace with generated posts

        SuggestionsPreviewResponse suggestionsPreviewResponse = SuggestionsPreviewResponse.builder().posts(postList).build();

        return suggestionsPreviewResponse;
    }
}
