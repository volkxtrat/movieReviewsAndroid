package com.android.moviereviews;

import com.android.moviereviews.model.ReviewsResponse;
import com.android.moviereviews.network.ReviewsService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.RobolectricTestRunner;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class ReviewsPresenterTest {

    @Rule
    public final MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public final RxSchedulersRule mSchedulersRule = new RxSchedulersRule();

    @Mock
    private ReviewsService mReviewsService;

    @Mock
    private ReviewsPresenter.Listener mListener;

    @InjectMocks private ReviewsPresenter mPresenter;

    @Before
    public void setUp() {
        ReviewsResponse response = new ReviewsResponse();
        when(mReviewsService.getMovieReviews(anyInt())).thenReturn(Observable.just(response));

        mPresenter.addListener(mListener);
    }

    @Test
    public void getStories() {
        TestObserver<ReviewsResponse> testObserver = mPresenter.getAllReviews(20).test();
        testObserver.awaitTerminalEvent();
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1);

    }
}
