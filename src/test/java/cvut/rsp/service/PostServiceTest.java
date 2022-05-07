package cvut.rsp.service;

import cvut.rsp.api.repository.IPostRepository;
import cvut.rsp.dao.entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    IPostRepository postRepository;

    @Captor
    ArgumentCaptor<Post> argumentCaptor;

    @InjectMocks
    PostService service;

    @Test
    void testGetAllPosts() {
        //Act
        service.getAllPosts();

        //Verifying
        Mockito.verify(postRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testGetPost() {
        //Arrange
        long id = 3;

        //Act
        service.getPost(id);

        //Verifying
        Mockito.verify(postRepository, Mockito.times(1)).getById(id);
    }

    @Test
    void testDeleteAllPosts() {
        //Act
        service.deleteAllPosts();

        //Verifying
        Mockito.verify(postRepository, Mockito.times(1)).deleteAll();
    }

    @Test
    void testCreatePost() {
        //Arrange
        LocalDate mockedTime = LocalDate.now();
        MockedStatic<LocalDate> timeMockedStatic = Mockito.mockStatic(LocalDate.class);
        timeMockedStatic.when(LocalDate::now).thenReturn(mockedTime);

        String expectedTitle = "Lion King";
        String expectedAuthor = "Ramin Djawadi";
        String expectedType = "Musical";


        //Act
        service.createPost(expectedTitle, expectedAuthor, expectedType);

        //Assert & Verifying
        Mockito.verify(postRepository, Mockito.times(1)).save(argumentCaptor.capture());

        Post actualPost = argumentCaptor.getValue();
        assertEquals(expectedAuthor, actualPost.getAuthor());
        assertEquals(expectedTitle, actualPost.getTitle());
        assertEquals(expectedType, actualPost.getType());
        assertEquals(LocalDate.now(), actualPost.getCreatedDate());
    }
}