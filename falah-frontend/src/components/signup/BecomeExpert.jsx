import React , {useState} from 'react';
import { ThemeProvider } from "@mui/material/styles";
import theme from '../../style/theme';
import {Grid, Avatar, CssBaseline, Container, Box, TextField, FormControlLabel, Checkbox, Button, Paper, MenuItem} from '@mui/material'
import signinimg from '../../res/images/signinimg.png'
import ManageAccountsIcon from '@mui/icons-material/ManageAccounts';
import Typography from '@mui/material/Typography';
import Link from "@mui/material/Link";
import{signUpService }from "../../service/signing";
import Appbar from "../../components/home/Appbar"
const BecomeExpert = () => {
    const [isExpert, setIsExpert] = useState(false);
    const [value, setValue] = useState("");

    const [successful, setSuccessful] = useState(false);
    const handleSubmit = (event) => {
      signUpService(event, setSuccessful, true);

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
           < Appbar/>
      <Grid container component="main">

        <Grid container xs={12}>
        <Grid item xs={4}/>
        <Grid   container
  direction="column"
  justifyContent="space-between"
  alignItems="center"  item xs={4}>
        <Grid item  xs={6}>
        <Grid item xs={6}>
            </Grid>
        <Avatar align='center'  sx={{ m: 1, bgcolor: "#007155" }}  style={{marginLeft: '125px'}}>
                <ManageAccountsIcon />
              </Avatar>{" "}
      <Typography
                fontSize="20px"
            >
                Submit You Expert Application
            </Typography></Grid>
            <Grid item xs={6}>
            </Grid>
              </Grid>
              <Grid item xs={4}/>
              </Grid>
              <Box
                component="form"
                noValidate
                onSubmit={handleSubmit}
                sx={{ mt: 3 }}
              >
               <Grid xs={12}
  container
  direction="row"
  justifyContent="space-between"
  alignItems="center" spacing={8}
>
    <Grid xs={1}></Grid>
    <Grid item container spacing={2} xs={5}>
                  <Grid item xs={12} sm={12}>
        
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
                    
                    
                    </Grid>
                    </Grid>

                    <Grid item container xs={6}> 
                    <Grid item xs={12} sm={12}>

                          <TextField
            autoFocus
            margin="dense"
            id="description"
            name="description"
            label="Donnez une petite description sur ce que vous faite pour vous client"
            multiline
            fullWidth
            variant="outlined"
          />
                    </Grid>  
                    <Grid item xs={12} sm={12}>
   
                     <TextField
                      required
                      fullWidth
                      id="phone"
                      label="Numero de telephone"
                      name="Numero de telephone"
                      autoComplete="family-name"
                      color="primary"
                    /> </Grid>
                                      <Grid item xs={12} sm={12}>

                        <div>Inserez la carte nationale d'identité</div>
                        <input
                          class="form-control"
                          type="file"
                          id="cin"
                          name="cin"
                          accept="image/*,application/pdf"
                        /> </Grid>
                                          <Grid item xs={12} sm={12}>

                        <div>Inserez votre formation </div>
                        <input
                          class="form-control"
                          type="file"
                          id="certificate"
                          name="certificate"
                          accept="image/*,application/pdf"
                        />
                     </Grid>
                    
                     
                     <Grid item xs={12} sm={12}>

                       <div>Inserez votre Image</div>
                        <input
                          class="form-control"
                          type="file"
                          id="image"
                          name="image"
                          accept="image/*,application/pdf"
                        />
                        </Grid>
                        <Grid item xs={12} sm={12}>
                        <Typography
                fontSize="15px"
                color="red"
                 >
               * Une fois votre application est validé par l'admin vous recevez un email !
            </Typography>
                  </Grid>
                  </Grid>
                </Grid>{" "}
                <Grid container item xs={12}>
                <Grid item  xs={4}></Grid>
                <Grid item  xs={2}> <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  color="primary"
                  width="500px"
                  sx={{ mt: 3, mb: 2 }}
                >
                  Submit Your Application{" "}
                </Button>{" "}
                </Grid>
                
                <Grid item  xs={5}>
                
               


                </Grid>
                </Grid>
               
      
                </Box></Grid>
    
    
    </ThemeProvider>
    );
};

export default BecomeExpert;