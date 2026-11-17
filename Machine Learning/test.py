
import pickle
import numpy as np

# 1. Load the trained model
with open("model.pkl", "rb") as file:
    model = pickle.load(file)


# 2. Create a prediction function
def predict_house_price(size):

    # 3. Prepare the input
    input_data = np.array([[size]])

    # 4. Ask the model to make a prediction
    prediction = model.predict(input_data)

    # 5. Return the prediction
    return prediction[0]


# 6. Accept input from the user
house_size = float(input("Enter house size in square metres: "))

# 7. Display prediction
price = predict_house_price(house_size)

print(f"Predicted house price: R{price:,.2f}")
