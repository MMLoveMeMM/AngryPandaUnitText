package com.liu.zhibao.angrypandaunittext.net;

import android.util.Log;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Created by zhibao.Liu on 2018/10/9.
 *
 * @version :
 * @date : 2018/10/9
 * @des :
 * @see{@link}
 */
public class GithubServiceTest {
    private static final String TAG = "GithubServiceTest";
    GithubService githubService;

    @Before
    public void setUp() throws URISyntaxException {
        //输出日志
        // ShadowLog.stream = System.out;
        githubService = GithubService.Factory.create();
    }

    @Test
    public void publicRepositories() throws IOException {
        /*Call<List<Repository>> call = githubService.publicRepositories("geniusmart");
        Response<List<Repository>> execute = call.execute();

        List<Repository> list = execute.body();
        //可输出完整的响应结果，帮助我们调试代码
        Log.i(TAG,new Gson().toJson(list));
        assertTrue(list.size() > 0);
        assertNotNull(list.get(0).name);*/

        Response<User> userResponse = githubService.user("geniusmart").execute();
        assertEquals(userResponse.body().login,"0geniusmart");
    }

}