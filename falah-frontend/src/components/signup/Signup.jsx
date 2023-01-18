import React , {useState} from 'react';
import { ThemeProvider } from "@mui/material/styles";
import theme from '../../style/theme';
import {Grid, Avatar, CssBaseline, Container, Box, TextField, FormControlLabel, Checkbox, Button, Paper, MenuItem} from '@mui/material'
import signinimg from '../../res/images/signinimg.png'
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Link from "@mui/material/Link";
import{signUpService }from "../../service/signing"
const Signup = () => {
    const [isExpert, setIsExpert] = useState(false);
    const [value, setValue] = useState("");

    const [successful, setSuccessful] = useState(false);
    const handleSubmit = (event) => {
      signUpService(event, setSuccessful, isExpert);

    }
    const handleChange = (e) => {
      setValue(e.target.value);
      if (e.target.value == "expert") setIsExpert(true);
      else setIsExpert(false);

    }
    const handleFileUpload = (e) => {
      console.log(e.target.files[0].name);
    };
    function Copyright(props) {
        return (
          <Typography
            variant="body2"
            color="text.secondary"
            align="center"
            {...props}
          >
            {" "}
            {"Copyright © "}{" "}
            <Link color="inherit" href="https://mui.com/">
              FALAH{" "}
            </Link>{" "}
            {new Date().getFullYear()} {"."}{" "}
          </Typography>
        );
      }

    return (
        <ThemeProvider theme={theme}>
      <Grid container component="main" sx={{ height: "100vh" }}>
        <CssBaseline />
        <Grid
          item
          xt={1}
          xs={false}
          sm={4}
          md={7}
          sx={{
            
            backgroundImage: `url(${signinimg})`,
            backgroundRepeat: "no-repeat",
            backgroundAttachment: "scroll",
            backgroundColor: (t) =>
              t.palette.mode === "light"
                ? t.palette.grey[50]
                : t.palette.grey[900],
            backgroundSize: "cover",
            backgroundPosition: "center",
          }}
        />
        <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square >
          <Container component="main" maxWidth="xs" sx={{my:10,mx:2,backgroundColor:"rgb(255,255,255,0.5)" }}>
            <CssBaseline />
            <Box
              sx={{
                width: "500px",
                marginTop: "10%",
                display: "flex",
                flexDirection: "column",
                alignItems: "center",
              }}
            >
              <Avatar sx={{ m: 1, bgcolor: "secondary" }}>
                <LockOutlinedIcon />
              </Avatar>{" "}
              <Typography component="primary" variant="h5" color="success">
                Sign up{" "}
              </Typography>{" "}
              <Box
                component="form"
                noValidate
                onSubmit={handleSubmit}
                sx={{ mt: 3 }}
              >
                <Grid container spacing={2}>
                  <Grid item xs={12} sm={12}>
                    <TextField
                      id="id"
                      name="name"
                      select
                      onChange={handleChange}
                      native="true"
                      color="primary"
                      required
                      label="Choissez votre profil"
                      style={{ width: 400 }}

                      //margin="normal"
                      //variant="outlined"
                      // color = "success"

                      // inputRef={register({ required: "Choose one option" })}
                    >
                      <MenuItem value="">Choisissez une option</MenuItem>
                      <MenuItem value="expert">expert</MenuItem>
                      <MenuItem value="user">user</MenuItem>
                    </TextField>
                  </Grid>{" "}
                  <Grid item xs={12} sm={12}>
                    <TextField
                      autoComplete="given-name"
                      name="firstName"
                      required
                      fullWidth
                      id="firstName"
                      label="First Name"
                      color="primary"
                      autoFocus
                    />
                  </Grid>{" "}
                  <Grid item xs={12} sm={12}>
                    <TextField
                      required
                      fullWidth
                      id="lastName"
                      label="Last Name"
                      name="lastName"
                      autoComplete="family-name"
                      color="primary"
                    />
                  </Grid>
                  <Grid item xs={12}>
                  <TextField
                      required
                      fullWidth
                      id="profession"
                      label="profession "
                      name="profession"
                      autoComplete="family-name"
                      color="primary"
                    />
                  </Grid>
                  <Grid item xs={12}>
                    <TextField
                      required
                      fullWidth
                      id="email"
                      label="Email Address"
                      name="email"
                      autoComplete="email"
                      color="primary"
                    />
                  </Grid>{" "}
                  <Grid item xs={12}>
                    <TextField
                      required
                      fullWidth
                      name="password"
                      label="Password"
                      type="password"
                      id="password"
                      autoComplete="new-password"
                      color="primary"
                    />
                    {isExpert && (
                      <div>
                        <div>Inserez la carte nationale d'identité</div>
                        <input
                          class="form-control"
                          type="file"
                          id="cin"
                          name="cin"
                          accept="image/*,application/pdf"
                        />
                        <div>Inserez votre formation </div>
                        <input
                          class="form-control"
                          type="file"
                          id="certificate"
                          name="certificate"
                          accept="image/*,application/pdf"
                        />
                     
                      </div>
                    )}
                       <div>Inserez votre Image</div>
                        <input
                          class="form-control"
                          type="file"
                          id="image"
                          name="image"
                          accept="image/*,application/pdf"
                        />
                  </Grid>
                  <Grid item xs={12}></Grid>{" "}
                </Grid>{" "}
                <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  color="primary"
                  sx={{ mt: 3, mb: 2 }}
                >
                  Sign Up{" "}
                </Button>{" "}
                <Grid container justifyContent="flex-end">
                  <Grid item>
                    <Link href="/signin" color="primary" variant="body2">
                      Already have an account ? Sign in
                    </Link>{" "}
                  </Grid>{" "}
                </Grid>{" "}
              </Box>{" "}
            </Box>{" "}
            <Copyright sx={{ mt: 5 }} />{" "}
          </Container>
        </Grid>
      </Grid>
      {successful && (
        <Box mt={5}>
          <div
            style={{
              padding: "10px",
              marginBottom: "-20px",
              borderRadius: "3px 3px 3px 3px",
              color: "#270",
              backgroundColor: "#DFF2BF",
            }}
          >
            Succès
          </div>
        </Box>
      )}{" "}
    </ThemeProvider>
    );
};

export default Signup;