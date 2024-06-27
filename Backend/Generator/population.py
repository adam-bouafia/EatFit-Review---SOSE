import requests
import random

# tt0411008 : LOST
FOOD_IDS = ['tt0411008', 'tt0108778']

def populate_reviews(n_users):
    URL = "http://localhost:8080/ReviewDataService/rest/Review/insertReview?foodID=%s&title=%s&text=%s&userID=%d"
    for food_id in FOOD_IDS:
        for i_user in range(n_users):
            res = requests.get(URL % (food_id, "Review title %d" % (random.randint(0, 1000)), "Test auto-generated review for food %s and user %d" % (food_id, i_user), i_user))
            print("[REVIEW] ", "FOOD", food_id, "USER", i_user, res.json())

def populate_ratings(n_users):
    URL = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/addRatings?userId=%d&foodId=%s&tasteRating=%d&nutritionalvalueRating=%d&overallsatisfactionRating=%d&packagingRating=%d&costumesRating=%d"
    for food_id in FOOD_IDS:
        for i_user in range(n_users):
            res = requests.get(URL % (i_user, food_id, random.randint(0, 10), random.randint(0, 10), random.randint(0, 10), random.randint(0, 10), random.randint(0, 10)))
            print("[RATING] ", "FOOD", food_id, "USER", i_user, res.json())

def populate_users(n_users):
    return

if __name__ == "__main__":
    populate_users(n_users = 30)
    populate_reviews(n_users = 30)
    populate_ratings(n_users = 30)